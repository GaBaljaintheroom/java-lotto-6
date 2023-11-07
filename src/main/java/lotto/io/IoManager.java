package lotto.io;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;

import java.util.function.Supplier;

public class IoManager {

    private final InputView inputView;
    private final InputMapper inputMapper;
    private final OutputView outputView;

    public IoManager(InputView inputView, InputMapper inputMapper, OutputView outputView) {
        this.inputView = inputView;
        this.inputMapper = inputMapper;
        this.outputView =  outputView;
    }

    public PurchasePrice inputPurchasePrice() {
        return read(() -> {
            outputView.printPurchasePriceMessage();
            String purchasePrice = inputView.inputPurchasePrice();
            return inputMapper.toPurchasePrice(purchasePrice);
        });
    }

    public Lotto inputLotto() {
        return read(() -> {
            outputView.printWinningNumbersMessage();
            String lotto = inputView.inputLotto();
            return inputMapper.toLotto(lotto);
        });
    }

    public BonusNumber inputBonusNumber(Lotto lotto) {
        return read(() -> {
            outputView.printBonusNumberMessage();
            String bonusNUmber = inputView.inputBonusNumber();
            return inputMapper.toBonusNumber(bonusNUmber, lotto);
        });
    }

    private <T> T read(Supplier<T> input) {
        while (true) {
            try {
                return input.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
