package lotto

import java.io.PrintWriter

interface Output {
    val writer: PrintWriter
    fun write()

    class PickNumber(
        private val lottoNumbers: List<LottoNumbers>,
        override val writer: PrintWriter = PrintWriter(System.out, true)
    ) : Output {
        override fun write() {
            lottoNumbers.map { it.joinToString(prefix = "[", postfix = "]") }
                .forEach { writer.write(it) }
        }
    }

    class LottoResult(
        private val lottoResult: LottoGame.Result,
        override val writer: PrintWriter = PrintWriter(System.out, true)
    ) : Output {
        override fun write() {
            writer.println(
                """
            당첨 통계
            ---------
                """.trimIndent()
            )
            val entries = lottoResult.entries()
            enumValues<Ranking.Rank>()
                .filterNot { it == Ranking.Rank.MISS }
                .forEach { rank ->
                    writer.println("${rank.match.count}개 일치 (${rank.amount}원)- ${entries[rank] ?: 0}개")
                }

            writer.println("총 수익률은 ${lottoResult.profit()}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
        }
    }
}
