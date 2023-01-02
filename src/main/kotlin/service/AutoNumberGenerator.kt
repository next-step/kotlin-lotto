package service

import domain.PurchasedLotto

class AutoNumberGenerator(
    private val randomNumberGenerator: RandomNumberGenerator
) {
    fun saveAfterGenerate(count: Int): List<PurchasedLotto>{
        val result = mutableListOf<PurchasedLotto>()
        for(i:Int in 0 until count){
            result.add(PurchasedLotto(randomNumberGenerator.getGeneratedNumber()))
        }
        return result
    }
}