package lotto.domain

object LottoResultAnalyzer {
    fun analyze(lottoList: List<List<Int>>, winningLotto: List<Int>): LottoResult {
        val result = lottoList.map { lotto ->
            lotto.count { it in winningLotto }
        }

        return LottoResult(
            totalLottoCount = lottoList.size,
            noneCount = result.count { it < 3 },
            fourthCount = result.count { it == 3 },
            thirdCount = result.count { it == 4 },
            secondCount = result.count { it == 5 },
            firstCount = result.count { it == 6 },
        )
    }

    data class LottoResult(
        val totalLottoCount: Int,
        val noneCount: Int,
        val fourthCount: Int,
        val thirdCount: Int,
        val secondCount: Int,
        val firstCount: Int,
    )
}
