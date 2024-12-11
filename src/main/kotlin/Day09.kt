import java.nio.file.Path


class Day09 {

    fun loadData(path: Path): String {
        return Resources.resourceAsText(path.fileName.toString())
    }

    fun filesystem(diskMap: String): List<Int> {
        val filesystem = mutableListOf<Int>()
        diskMap.forEachIndexed { index, char ->
            if (index % 2 == 0) {
                // file
                val fileSize = char.digitToInt()
                val fileId = index / 2
                repeat(fileSize) {
                    filesystem.add(fileId)
                }
            } else {
                // empty space
                val fileSize = char.digitToInt()
                repeat(fileSize) {
                    filesystem.add(FREE)
                }
            }
        }
        return filesystem
    }

    fun fragmenter(fileSystem: MutableList<Int>): List<Int> {
        var leftPointer = 0
        var rightPointer = fileSystem.size - 1
        while (leftPointer < rightPointer) {
            if (fileSystem[leftPointer] == FREE) {
                // swap
                val temp = fileSystem[leftPointer]
                fileSystem[leftPointer] = fileSystem[rightPointer]
                fileSystem[rightPointer] = temp
                rightPointer--
                while (fileSystem[rightPointer] == FREE) {
                    rightPointer--
                }
            }
            leftPointer++
        }
        return fileSystem
    }

    fun checksum(filesystem: List<Int>): Long {
        return filesystem.withIndex()
            .filter { it.value != FREE }
            .sumOf { it.index * it.value.toLong() }
    }

    fun solvePart1(diskMap: String): Long {
        val filesystem = filesystem(diskMap)
        val newFilesystem = fragmenter(filesystem.toMutableList())
        return checksum(newFilesystem)
    }

    fun freeSpace(fileSystem: List<Int>, fileSize: Int, end: Int): Int {
        for (index in 0..end - fileSize) {
            if (fileSystem.subList(index, index + fileSize).all { it == FREE }) {
                return index
            }
        }
        return -2
    }

    fun fileSize(fileSystem: List<Int>, pointer: Int): Int {
        val fileId = fileSystem[pointer]
        var fileSize = 1
        while (fileSystem[pointer - fileSize] == fileId) {
            fileSize++
        }
        return fileSize
    }

    fun defrag(fileSystem: MutableList<Int>): List<Int> {
        var rightPointer = fileSystem.size - 1
        while (fileSystem[rightPointer] != 0) {
            while (fileSystem[rightPointer] == FREE) {
                rightPointer--
            }
            val fileSize = fileSize(fileSystem, rightPointer)
            val freeSpace = freeSpace(fileSystem, fileSize, rightPointer)
            if (freeSpace == NO_FREE_SPACE) {
                rightPointer -= fileSize
                continue
            }
            for (dest in freeSpace..<freeSpace + fileSize) {
                fileSystem[dest] = fileSystem[rightPointer]
            }
            for (src in rightPointer - fileSize + 1..<rightPointer + 1) {
                fileSystem[src] = FREE
            }
            rightPointer -= fileSize
        }
        return fileSystem
    }

    fun solvePart2(diskMap: String): Long {
        val filesystem = filesystem(diskMap)
        val newFilesystem = defrag(filesystem.toMutableList())
        return checksum(newFilesystem)
    }

    companion object {
        const val FREE = -1
        const val NO_FREE_SPACE = -2
    }

}

fun main() {
    val day09 = Day09()
    val diskMap = day09.loadData(Path.of("src", "main", "resources", "Day09_InputData.txt"))
    println("part1: ${day09.solvePart1(diskMap)}")
    println("part2: ${day09.solvePart2(diskMap)}")
}