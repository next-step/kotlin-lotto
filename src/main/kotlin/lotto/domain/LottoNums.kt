package lotto.domain

import lotto.domain.generator.Generator
import java.util.stream.IntStream
import kotlin.streams.toList

class LottoNums(generator: Generator): Iterable<LottoNum> {

    private val numbers: List<LottoNum> = IntStream.rangeClosed(1, LOTTO_NUM_COUNT)
        .mapToObj { LottoNum(generator) }
        .toList()

    override fun iterator(): Iterator<LottoNum> = numbers.iterator()

    companion object {
        const val LOTTO_NUM_COUNT = 6
    }
}