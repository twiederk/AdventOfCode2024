class Day09 {

    fun checksum(fileSystem: String): Int {
        return fileSystem.mapIndexed { index, char -> if (char == '.') 0 else index * char.digitToInt()  }.sum()
    }
}