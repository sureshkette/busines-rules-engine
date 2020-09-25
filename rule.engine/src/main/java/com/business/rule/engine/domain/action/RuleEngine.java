package com.business.rule.engine.domain.action;

import com.business.rule.engine.delivery.model.ProductCategory;
import com.business.rule.engine.domain.rulehandlers.MemberShipActivate;
import com.business.rule.engine.domain.rulehandlers.MemberShipUpgrade;
import com.business.rule.engine.domain.rulehandlers.PackingSlip;
import com.business.rule.engine.domain.rulehandlers.PaymentToAgent;
import org.springframework.stereotype.Service;

@Service
public class RuleEngine {
    public String go(String order, ProductCategory productCategory) {
        //For each product category execute the rules
        //new rules can be added in rulehandlers and can be executed from RuleEngine go method
        if (productCategory.equals(ProductCategory.PHYSICAL_PRODUCT)) {
            PackingSlip.generateForShipping(order);
            PaymentToAgent.generateCommissionPayment(order);
            return "Physical product business rule executed";
        }
        if (productCategory.equals(ProductCategory.BOOK)) {
            PackingSlip.generateForRoyalty(order);
            PaymentToAgent.generateCommissionPayment(order);
            return "Book business rule executed";
            //return packing slip
        }
        if (productCategory.equals(ProductCategory.MEMBERSHIP_ACTIVATE)) {
            MemberShipActivate.activateMemberShip(order);
            MemberShipActivate.notifyActivation(order);
            return "Membership activate business rule executed";
        }
        if (productCategory.equals(ProductCategory.MEMBERSHIP_UPGRADE)) {
            MemberShipUpgrade.updateMemberShip(order);
            MemberShipUpgrade.notifyUpdate(order);
            return "Membership Update business rule executed";
        }
        return "Product category not matched";
    }
}

