package shffule

class RandomShuffler<T> : Shuffler<T> {

    override fun shuffled(source: List<T>): List<T> {
        return source.shuffled()
    }
}
