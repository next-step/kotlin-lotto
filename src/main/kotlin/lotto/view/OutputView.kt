package lotto.view

import lotto.dto.RoiDto

object OutputView {
    fun write(roiDTO: RoiDto) {
        if (roiDTO.value in 0.0..1.0)
            println("총 수익률은 $roiDTO 입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임) \n ")
        else
            println("총 수익률은 $roiDTO 로 이익입니다. \n ")
    }

    fun writeSingleOutput(message: String) {
        println(message)
    }
}
