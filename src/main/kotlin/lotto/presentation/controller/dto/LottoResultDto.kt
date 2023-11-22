package lotto.presentation.controller.dto

data class LottoResultDto(
    val resultTable: List<List<Int>>,
    val earingRate: Double
) {

    companion object {
        fun of(resultTable: List<List<Int>>, earingRate: Double): LottoResultDto {
            return LottoResultDto(resultTable, earingRate)
        }
    }
}