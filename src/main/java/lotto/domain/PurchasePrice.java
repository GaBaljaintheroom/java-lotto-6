package lotto.domain;

import lotto.exception.NotThousandUnitException;

public class PurchasePrice {

    private static final Integer UNIT = 1000;
    private static final Integer NOT_REMAIN = 0;

    private final Integer lottoPurchasePrice;

    private PurchasePrice(Integer purchasePrice) {
        validateThousandUnit(purchasePrice);
        this.lottoPurchasePrice = purchasePrice;
    }

    public static PurchasePrice from(Integer purchasePrice) {
        return new PurchasePrice(purchasePrice);
    }

    private void validateThousandUnit(Integer purchasePrice) {
        if (isNotThousandUnit(purchasePrice)) {
            throw new NotThousandUnitException();
        }
    }

    private boolean isNotThousandUnit(Integer purchasePrice) {
        return purchasePrice % UNIT != NOT_REMAIN;
    }

    public Integer getLottosAmount() {
        return lottoPurchasePrice / UNIT;
    }
}
