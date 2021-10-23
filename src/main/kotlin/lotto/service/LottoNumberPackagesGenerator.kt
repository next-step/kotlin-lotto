package lotto.service

import lotto.domain.LottoNumberPackage

interface LottoNumberPackagesGenerator {
    fun generate(count: Int): List<LottoNumberPackage>
}
