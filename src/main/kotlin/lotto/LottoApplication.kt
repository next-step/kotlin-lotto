package lotto

fun main() {
    println("구입금액을 입력해 주세요.")
    val input = readlnOrNull()?.trim()
    if (input.isNullOrEmpty()) throw Exception("금액을 입력되지 않았습니다.")

    val purchaseAmount = input.toIntOrNull() ?: throw Exception("숫자로 입력하지 않았습니다.")
    if (purchaseAmount <= 0) throw Exception("금액은 양수입니다.")
    val purchasedLottoCount = (purchaseAmount / TICKET_PRICE)
    println("${purchasedLottoCount}개를 구매했습니다.")

    val purchasedLottos = mutableListOf<List<Int>>()
    repeat(purchasedLottoCount) { idx ->
        val lotto = listOf<Int>() // createLotto()
        purchasedLottos.add(lotto)
    }

    println("지난 주 당첨 번호를 입력해 주세요.")
    val input2 = readlnOrNull()?.trim()
    if (input2.isNullOrEmpty()) throw Exception("당첨 번호를 입력되지 않았습니다.")
    val winningNumbers = input2.split(",").map { it.toIntOrNull() ?: throw Exception("숫자로 입력하지 않았습니다.") }
    if (winningNumbers.size != LOTTO_NUMBER_COUNT) throw Exception("당첨 번호는 6개의 숫자로 이루어져야 합니다.")

    println("당첨 통계")
    println("--------")

    val matchedLottoNumberCounts = mutableMapOf<Int, Int>()

    repeat(purchasedLottoCount) { idx ->
        val matchedLottoNumberCount = 4 // countMatchedLottoNumber(winningNumbers, purchasedLottos[idx])
        if (matchedLottoNumberCount >= 3) {
            val count = matchedLottoNumberCounts.getOrDefault(matchedLottoNumberCount, 0)
            matchedLottoNumberCounts[matchedLottoNumberCount] = count + 1
        }
    }
    println("3개 일치 (5000원)- ${matchedLottoNumberCounts.getOrDefault(3, 0)}개")
    println("4개 일치 (50000원)- ${matchedLottoNumberCounts.getOrDefault(4, 0)}개")
    println("5개 일치 (150000원)- ${matchedLottoNumberCounts.getOrDefault(5, 0)}개")
    println("6개 일치 (2000000000원)- ${matchedLottoNumberCounts.getOrDefault(6, 0)}개")

    val prizeAmount =
        (5000 * matchedLottoNumberCounts.getOrDefault(3, 0)) +
            (50000 * matchedLottoNumberCounts.getOrDefault(4, 0)) +
            (150000 * matchedLottoNumberCounts.getOrDefault(5, 0)) +
            (2000000000 * matchedLottoNumberCounts.getOrDefault(6, 0))
    println("총 수익률은 ${(prizeAmount / purchaseAmount)}입니다.")
}

private const val TICKET_PRICE = 1000
private const val LOTTO_NUMBER_COUNT = 6
