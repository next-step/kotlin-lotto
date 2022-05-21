package lotto

class ResultView(private val output: Output) {
    fun showLottos(lottos: List<List<Int>>) {
        output.print("${lottos.size}개를 구입했습니다.")
        lottos.forEach { output.print(it.toString()) }
    }

    fun showAnalyzeResult(lottoResult: Map<String, Any>) {
        println("당첨 통계")
        println("---------")
        lottoResult.forEach {
            val (key, value) = it
            output.print(parseFor(key, value))
        }
    }

    fun parseFor(key: String, value: Any): String {
        return if (key.toIntOrNull() != null) "${key}개 일치 (${(value as List<Int>)[0]}원)- ${(value as List<Int>)[1]}개"
        else "총 수익률은 ${value}입니다.(기준이 1이기 때문에 결과적으로 ${if ((value as String).toDouble() > 1) "이득이" else "손해"}라는 의미임)"
    }
}