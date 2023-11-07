package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningLotto;
import lotto.io.IoManager;
import lotto.io.OutputView;
import lotto.service.LottoService;

public class LottoController {

    private final IoManager ioManager;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(IoManager ioManager, OutputView outputView, LottoService lottoService) {
        this.ioManager = ioManager;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        purchaseLottos();
        inputWinningLotto();
        resultLottoStatistics();
    }

    private void purchaseLottos() {
        PurchasePrice purchasePrice = ioManager.inputPurchasePrice();
        lottoService.saveLottos(purchasePrice);
        outputView.printLottoResultMessage(lottoService.getPlayerLottoNumbers());
    }

    private void inputWinningLotto() {
        Lotto lotto = ioManager.inputLotto();
        BonusNumber bonusNumber = ioManager.inputBonusNumber(lotto);

        WinningLotto winningLotto = WinningLotto.of(lotto, bonusNumber);
        lottoService.saveWinningLotto(winningLotto);
    }

    private void resultLottoStatistics() {
        outputView.printWinningStatisticsMessage();
        lottoService.calculateWinningStatistics();
        lottoService.calculateTotalRate();
        outputView.printGameResultMessage(lottoService.getGameResult());
    }
}
