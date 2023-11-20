package lotto.view

import lotto.domain.model.Lotto

private const val BUY_LOTTO_PRICE_DESCRIPTION = "구입금액을 입력해 주세요."
private const val BUY_LOTTO_COUNT_DESCRIPTION = "%d개를 구매했습니다."
private const val LAST_WEEK_WINNING_NUMBER_DESCRIPTION = "지난 주 당첨 번호를 입력해 주세요."
private const val LAST_WEEK_WINNING_BONUS_NUMBER_DESCRIPTION = "보너스 볼을 입력해 주세요."

/**
 * 입력 뷰
 * */
object InputView {

    enum class InputType(val description: String) {
        BUY_LOTTO_PRICE(BUY_LOTTO_PRICE_DESCRIPTION), LAST_WEEK_WINNING_NUMBER(LAST_WEEK_WINNING_NUMBER_DESCRIPTION), LAST_WEEK_WINNING_NUMBER_BONUS(LAST_WEEK_WINNING_BONUS_NUMBER_DESCRIPTION)
    }

    /**
     * 공통 input 뷰
     * */
    fun getInputValue(type: InputType): String {
        drawInputType(type)
        return readln()
    }

    private fun drawInputType(type: InputType) {
        println(type.description)
    }

    /**
     * 로또 목록
     * */
    fun drawLottoList(lottoList: List<Lotto>){
        println(BUY_LOTTO_COUNT_DESCRIPTION.format(lottoList.size))
        lottoList.forEach {
            println(it.lottoNumbers.numbers)
        }
        println()
    }
}
