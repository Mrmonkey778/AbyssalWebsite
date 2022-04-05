package com.example.demo.Content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/content")
public class ContentController {

    private final ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping
    public List<Content> getContent(){
        return contentService.getContent();
    }

    //take the request body and map into a content object
    @PostMapping
    public void registerNewContent(@RequestBody Content content){
        contentService.addNewContent(content);
    }

    @DeleteMapping(path = "{contentID}")
    public void deleteStudent(@PathVariable("contentID") Long contentId){
        contentService.deleteContent(contentId);
    }


    @PutMapping(path = "{contentId}")
    public void updateContent(@PathVariable("contentId") Long contentId,
                              @RequestParam(required = true) String name,
                              @RequestParam(required = false) String desc,
                              @RequestParam(required = true) Integer type){
        contentService.updateContent(contentId, name, desc, type);

        //Long contentId, String name, String desc, Integer t


    }
}
