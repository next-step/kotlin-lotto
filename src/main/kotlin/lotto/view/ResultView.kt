package lotto.view

class ResultView {
    fun show(result: Map<Int, Int>, benefit: String) {
        println("당첨 통계")
        println("---------")
        (1..4).reversed().forEach { 
            showOne(it, result.getOrDefault(it, 0))
        }
        
        val bep = if (benefit.toDouble() > 1.0) "이익" else "손해"
        println("총 수익률은 ${benefit}입니다. (기준이 1이기 때문에 결과적으로 ${bep}라는 의미임)")
    }
    
    private fun showOne(rank: Int, count: Int) {
        when (rank) {
            1 -> println("6개 일치 (2000000000원) - ${count}개")
            2 -> println("5개 일치 (1500000원) - ${count}개")
            3 -> println("4개 일치 (50000원) - ${count}개")
            4 -> println("3개 일치 (5000원) - ${count}개")
        }
    }
}
