package lotto.domain

enum class LottoMessage(
    val message: String
) {
    INPUT_PURCHASE_FEE("구입금액을 입력해 주세요."),
    PRINT_PURCHASE_QUANTITY("%d개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("지난 주 당첨 번호를 입력해 주세요."),
    PRINT_LOTTO_STATISTICS("당첨 통계\n---------"),
    PRINT_LOTTO_RANK("%d개 일치 (%d원)- %d개"),
    ;

    override fun toString(): String = this.message
}
