package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;
    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry)
    {
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getEntryById(@PathVariable ObjectId myId)
    {
       // orelse isiliye kyuki service file me ye method ka datatype optional h matlab kuchh ho bhi sakta h return ya nhi ,to bs return nhi kr sakte orelse krna hoga
        return journalEntryService.findById(myId).orElse(null);
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteEntryById(@PathVariable ObjectId myId)
    {

         journalEntryService.deleteById(myId);
         return true;
    }

    @PutMapping("id/{id}")
    public JournalEntry updateEntryById(@PathVariable ObjectId id, @RequestBody JournalEntry myEntry)
    {
      JournalEntry old=journalEntryService.findById(id).orElse(null);


    }


}
