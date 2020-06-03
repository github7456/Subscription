package com.newsletter.subscription.repositories;

import com.newsletter.subscription.models.Subscription;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionRepository extends CrudRepository<Subscription, String> {

}
