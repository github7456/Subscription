package com.newsletter.subscription.controllers;

import com.newsletter.subscription.models.Subscription;
import com.newsletter.subscription.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SubscriptionController {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/subscribers")
    public String showSubscribers(Model model) {
        model.addAttribute("sub", new Subscription());
        model.addAttribute("subs", subscriptionRepository.findAll());
        return "subscribers";
    }

    @GetMapping("/subscribe")
    public String addSubscription(@RequestParam("name") String name, @RequestParam("email") String email) {
        Subscription sub = new Subscription();
        sub.setName(name);
        sub.setEmail(email);
        subscriptionRepository.save(sub);
        return "subscribed";
    }

    @GetMapping("/unsubscribe")
    public String removeSubscription(@RequestParam("email") String email) {
        if (subscriptionRepository.findById(email).isPresent()) {
            subscriptionRepository.deleteById(email);
        }

        return "unsubscribed";
    }
}
