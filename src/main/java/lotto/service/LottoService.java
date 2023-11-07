package lotto.service;

import lotto.domain.Numbers;
import lotto.domain.PlayerLottoNumbers;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningLotto;
import lotto.domain.statistics.LottoStatistics;
import lotto.domain.statistics.TotalRate;
import lotto.formatter.GameResultFormatter;
import lotto.formatter.PlayerLottosFormatter;

public class LottoService {

    private final PlayerLottoNumbers playerLottoNumbers;
    private final LottoStatistics lottoStatistics;
    private final TotalRate totalRate;
    private WinningLotto winningLotto;

    public LottoService(PlayerLottoNumbers playerLottoNumbers, LottoStatistics lottoStatistics, TotalRate totalRate) {
        this.playerLottoNumbers = playerLottoNumbers;
        this.lottoStatistics = lottoStatistics;
        this.totalRate = totalRate;
    }

    public void saveLottos(PurchasePrice purchasePrice) {
        playerLottoNumbers.saveLottos(purchasePrice);
    }

    public PlayerLottosFormatter getPlayerLottoNumbers() {
        return new PlayerLottosFormatter(playerLottoNumbers.getLottoValues());
    }

    public void saveWinningLotto(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void calculateWinningStatistics() {
        for (Numbers numbers : playerLottoNumbers.getLottoValues()) {
            Integer matchCount = numbers.getMatchCount(winningLotto.getLotto()).intValue();
            Boolean isMatchBonusNumber = numbers.isMatchBonusNumber(winningLotto.getBonusNumber());
            lottoStatistics.upWinningFactorValue(matchCount, isMatchBonusNumber);
        }
    }

    public void calculateTotalRate() {
        Integer lottosPrice = playerLottoNumbers.getLottosPrice();
        Integer winningSum = lottoStatistics.calculateWinningPrice();
        totalRate.calculateRate(lottosPrice, winningSum);
    }

    public GameResultFormatter getGameResult() {
        return new GameResultFormatter(lottoStatistics.getStatistics(), totalRate.getRate());
    }
}
