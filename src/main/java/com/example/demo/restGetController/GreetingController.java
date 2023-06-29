package com.example.demo.restGetController;

import com.example.demo.exceptions.NotFoundException;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/message")
public class GreetingController {

    public List<MessageData> messagesData = new ArrayList<>() {{
        add(new MessageData(1, "Text1"));
        add(new MessageData(2, "Text2"));
    }};

    private final AtomicLong idIncrement = new AtomicLong(messagesData.size());

    @GetMapping
    public List<MessageData> listMassage() {
        return messagesData;
    }

    @GetMapping("{id}")
    public MessageData getOneMessage(@PathVariable int id) {
        return getMessageWithId(id);
    }

    @PostMapping
    public MessageData createMessage(@RequestBody MessageDataRequest message) {
        long indexedId = idIncrement.incrementAndGet();
        messagesData.add(new MessageData(indexedId, message.getText()));
        return getMessageWithId(indexedId);
    }

    @PutMapping("{id}")
    public MessageData updateMessage(@PathVariable long id, @RequestBody MessageDataRequest messageToUpdate) {
        MessageData message = getMessageWithId(id);
        message.setText(messageToUpdate.getText());
        Assert.isTrue(Collections.replaceAll(messagesData, getMessageWithId(id), message), "");
        return message;
    }

    @DeleteMapping("{id}")
    public void deleteMessage(@PathVariable long id) {
        MessageData messageData = getMessageWithId(id);
        messagesData.remove(messageData);
    }

    private MessageData getMessageWithId(@PathVariable long id) {
        return messagesData.stream()
                .filter(message -> message.getId() == id)
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }
}
