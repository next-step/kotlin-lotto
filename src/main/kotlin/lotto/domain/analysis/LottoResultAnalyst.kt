package lotto.domain.analysis

interface LottoResultAnalyst {

    fun analyze(request: LottoAnalysisRequest): LottoAnalysisResult
}
