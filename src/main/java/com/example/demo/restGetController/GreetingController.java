package com.example.demo.restGetController;

import com.example.demo.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    public List<MessageDataResponse> messagesData = new ArrayList<MessageDataResponse>() {{

        add(new MessageDataResponse(1, "Text1"));
        add(new MessageDataResponse(2, "Text2"));
    }};

    @GetMapping
    public List<MessageDataResponse> listMassage() {
        return messagesData;
    }

    @GetMapping("{id}")
    public MessageDataResponse getOneMessage(@PathVariable int id) {
        return getMessageWithId(id);
    }

    @PostMapping
    public MessageDataResponse createMessage(@RequestBody MessageDataRequest message) {
        int lastId = messagesData.stream().max(Comparator.comparing(MessageDataResponse::getId)).get().getId();
        int indexedId = ++lastId;
        messagesData.add(new MessageDataResponse(indexedId, message.getText()));
        return getMessageWithId(indexedId);
    }

    @PutMapping("{id}")
    public MessageDataResponse updateMessage(@PathVariable int id, @RequestBody MessageDataRequest messageToUpdate) {
        MessageDataResponse message = getMessageWithId(id);
        message.setText(messageToUpdate.getText());
        Collections.replaceAll(messagesData, getMessageWithId(id), message);
        return message;
    }

    private MessageDataResponse getMessageWithId(@PathVariable int id) {
        return messagesData.stream()
                .filter(message -> message.getId() == id)
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }
//    @GetMapping("{id}")
//    public Map<String, String> getOneMessage(@PathVariable String id) {
//        return messagesData.stream()
//                .filter(message -> message.get("id").equals(id))
//                .findFirst()
//                .orElseThrow(NotFoundException::new);
//    }

//    @PostMapping
//    public Map<String,String> create(@RequestBody)


//    private static final String template = "Hello? %s";
//    private final AtomicLong counter = new AtomicLong();
//
//    @GetMapping()
//    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
//        return new Greeting(counter.incrementAndGet(), String.format(template, name));
//    }
}
