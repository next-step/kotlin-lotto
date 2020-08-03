package lotto.view

import lotto.domain.ResultData

fun printResult(resultData: ResultData, money: Int) {
    print(
        """당첨 통계\n" +
            "---------\n" +
            "3개 일치 (5000원)- ${resultData.fourth}개\n" +
            "4개 일치 (50000원)- ${resultData.third}개\n" +
            "5개 일치 (1500000원)- ${resultData.second}개\n" +
            "6개 일치 (2000000000원)- ${resultData.first}개\n" +
            "총 수익률은 ${resultData.price / money}입니다.(기준이 1)"""
    )
}
