package lotto.view

import lotto.domain.model.*

/**
 * 입력 뷰
 * */
object InputView {

    private const val BUY_LOTTO_PRICE_DESCRIPTION = "구입금액을 입력해 주세요."
    private const val BUY_LOTTO_COUNT_DESCRIPTION = "수동으로 %d장, 자동으로 %d개를 구매했습니다."
    private const val WINNING_BONUS_NUMBER_DESCRIPTION = "보너스 볼을 입력해 주세요."
    private const val WINNING_LOTTO_NUMBER_DESCRIPTION = "지난 주 당첨 번호를 입력해 주세요."
    private const val WINNING_LOTTO_NUMBER_DELIMITER = ", "
    private const val SELF_LOTTO_NUMBER_DELIMITER = ", "
    private const val SELF_LOTTO_NUMBER_COUNT_DESCRIPTION = "수동으로 구매할 로또 수를 입력해 주세요."
    private const val SELF_LOTTO_NUMBER_DESCRIPTION = "수동으로 구매할 번호를 입력해 주세요."

    /**
     * 구입 금액 뷰
     * */
    fun drawBuyPrice(): BuyPrice {
        println(BUY_LOTTO_PRICE_DESCRIPTION)
        val buyPriceText = readln()
        println()

        require(buyPriceText.toIntOrNull() != null) {
            "구입 금액은 숫자만 들어올 수 있습니다."
        }

        return BuyPrice.valueOf(buyPriceText.toInt())
    }

    /**
     * 당첨 로또 번호들 뷰
     * */
    fun drawWinningLottoNumbers(): LottoNumbers {
        println(WINNING_LOTTO_NUMBER_DESCRIPTION)
        val winningNumbersText = readln()

        require(winningNumbersText.isNotBlank()) {
            "로또 당첨 번호는 비어 있을 수 없습니다."
        }

        val winningNumbers = winningNumbersText.split(WINNING_LOTTO_NUMBER_DELIMITER)

        require(winningNumbers.all { winningNumber -> winningNumber.toIntOrNull() != null }) {
            "로또 당첨 번호들은 숫자만 들어올 수 있습니다."
        }

        return LottoNumbers.valueOf(winningNumbers.map { winningLottoNumber -> winningLottoNumber.toInt() }.toSet())
    }

    /**
     * 수동 로또 번호들 뷰
     * */
    private fun drawSelfLottoNumbers(): LottoNumbers {

        val selfLottoNumbersText = readln()

        require(selfLottoNumbersText.isNotBlank()) {
            "수동 로또 번호는 비어 있을 수 없습니다."
        }

        val selfLottoNumbers = selfLottoNumbersText.split(SELF_LOTTO_NUMBER_DELIMITER)

        require(selfLottoNumbers.all { selfLottoNumber -> selfLottoNumber.toIntOrNull() != null }) {
            "수동 로또 번호는 숫자만 들어올 수 있습니다."
        }

        return LottoNumbers.valueOf(selfLottoNumbers.map { selfLottoNumber -> selfLottoNumber.toInt() }.toSet())
    }

    /**
     * 수동 로또 넘버들
     * */
    fun getSelfLottoNumbers(): Lottos {
        val selfLottoNumbersCount = drawSelfLottoNumbersCount()

        println("\n${SELF_LOTTO_NUMBER_DESCRIPTION}")

        val selfLottoNumbers = mutableListOf<Lotto>()
        repeat(selfLottoNumbersCount.toInt()) {
            selfLottoNumbers.add(Lotto.from(drawSelfLottoNumbers()))
        }

        return Lottos.from(selfLottoNumbers)
    }

    /**
     * 수동으로 구매할 로또 개수
     * */
    private fun drawSelfLottoNumbersCount(): SelfLottoNumberCount {
        println(SELF_LOTTO_NUMBER_COUNT_DESCRIPTION)
        val selfLottoBuyCount = readln()

        require(selfLottoBuyCount.toIntOrNull() != null) {
            "수동으로 구매할 로또 개수는 숫자만 들어올 수 있습니다."
        }

        return SelfLottoNumberCount.from(selfLottoBuyCount.toInt())
    }

    /**
     * 보너스 번호 뷰
     * */
    fun drawWinningBonusNumber(winningLottoNumbers: LottoNumbers): LottoNumber {
        println(WINNING_BONUS_NUMBER_DESCRIPTION)
        val bonusLottoNumberText = readln()

        require(bonusLottoNumberText.toIntOrNull() != null) {
            "보너스 넘버는 숫자만 들어올 수 있습니다."
        }

        val bonusLottoNumber = LottoNumber.valueOf(bonusLottoNumberText.toInt())

        require(bonusLottoNumber !in winningLottoNumbers) {
            "보너스 넘버와 당첨 로또 번호는 겹칠 수 없습니다."
        }

        return bonusLottoNumber
    }

    /**
     * 로또 목록
     * */
    fun drawLottoList(selfLottos: Lottos, autoLottos: Lottos) {
        println(BUY_LOTTO_COUNT_DESCRIPTION.format(selfLottos.size, autoLottos.size))
        (selfLottos + autoLottos).forEach { lotto ->
            println(lotto.lottoNumbers.value)
        }
        println()
    }
}
