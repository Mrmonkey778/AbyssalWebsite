package com.example.demo.Content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ContentService {

    private final ContentRepository contentRepository;

    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Autowired
    public List<Content> getContent(){
        return contentRepository.findAll();
    }

    public void addNewContent(Content content) {
        Optional<Content> contentOptional = contentRepository.findContentByName(content.getName());
        if(contentOptional.isPresent()){
            throw new IllegalStateException("Name is taken");
        }
        contentRepository.save(content);
        System.out.println(content);
    }

    public void deleteContent(Long contentId) {
        if(contentRepository.existsById(contentId)){
            contentRepository.deleteById(contentId);
        }else{
            throw new IllegalStateException("Content ID " + contentId + " does not exist");
        }
    }

    @Transactional
    public void updateContent(Long contentId, String name, String desc, Integer type) {
        Content content = contentRepository.findById(contentId).orElseThrow(() -> new IllegalStateException(
                "content with id "+contentId + "does not exist"));
        if(name!=null &&name.length()>0 && !Objects.equals(content.getName(), name)){
            Optional<Content> contentOptional = contentRepository.findContentByName(name);
            if(contentOptional.isPresent()){
                throw new IllegalStateException("Name taken");
            }
            content.setName(name);
        }

        if(desc!=null && desc.length()>0 && !Objects.equals(content.getDescription(), desc)){
            content.setDescription(desc);
        }

        if(type!=null && type>0 && !Objects.equals(content.getType(), type)){
            content.setType(type);
        }
    }
}
