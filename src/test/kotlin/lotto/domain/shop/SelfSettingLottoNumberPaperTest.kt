package lotto.domain.shop

import lotto.domain.lottonumber.lottoNumbers

fun mockSelfSettingLottoNumbersPapers(size: Int): List<SelfSettingLottoNumberPaper> {
    return List(size) {
        SelfSettingLottoNumberPaper(lottoNumbers(1, 2, 3, 4, 5, 6))
    }
}
