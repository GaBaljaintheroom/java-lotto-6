package lotto.io;

import lotto.constants.ProgressMessage;
import lotto.formatter.PlayerLottosFormatter;
import lotto.formatter.GameResultFormatter;

public class OutputView {

    private OutputView() {}

    private static class OutputViewHelper {
        private static final OutputView INSTANCE = new OutputView();
    }

    public static OutputView getInstance() {
        return OutputViewHelper.INSTANCE;
    }

    public void printErrorMessage(String error) {
        System.out.println(error);
    }

    public void printPurchasePriceMessage() {
        System.out.println(ProgressMessage.INPUT_LOTTO_PURCHASE_PRICE_MESSAGE);
    }

    public void printLottoResultMessage(PlayerLottosFormatter lottoResultFormatter) {
        printNextLine();
        System.out.println(lottoResultFormatter.toResultLottoMessage());
    }

    public void printGameResultMessage(GameResultFormatter lottoStatisticsResultFormatter) {
        System.out.println(lottoStatisticsResultFormatter.toStatisticsResultMessage());
        System.out.println(lottoStatisticsResultFormatter.toTotalRateMessage());
    }

    public void printWinningNumbersMessage() {
        System.out.println(ProgressMessage.INPUT_WINNING_NUMBERS_MESSAGE);
    }

    public void printBonusNumberMessage() {
        printNextLine();
        System.out.println(ProgressMessage.INPUT_BONUS_NUMBER_MESSAGE);
    }

    public void printWinningStatisticsMessage() {
        printNextLine();
        System.out.println(ProgressMessage.WINNING_STATISTICS);
    }

    public void printNextLine() {
        System.out.println();
    }
}
