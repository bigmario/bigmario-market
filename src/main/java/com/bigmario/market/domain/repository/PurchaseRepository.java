package com.bigmario.market.domain.repository;

import com.bigmario.market.domain.Purchase;
import com.bigmario.market.domain.PurchaseItem;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase savePurchase(Purchase purchase);
}
