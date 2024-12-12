import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Path

class Day12Test {

    private val garden1 = listOf(
        "AAAA",
        "BBCD",
        "BBCC",
        "EEEC",
    )

    private val garden2 = listOf(
        "OOOOO",
        "OXOXO",
        "OOOOO",
        "OXOXO",
        "OOOOO",
    )

    private val areaA = listOf(
        Point2D(0, 0),
        Point2D(1, 0),
        Point2D(2, 0),
        Point2D(3, 0),
    )


    @Test
    fun should_load_data() {

        // act
        val garden = Day12().loadData(Path.of("src", "test", "resources", "Day12_TestData.txt"))

        // assert
        assertThat(garden).hasSize(10)
    }

    @Test
    fun should_find_area() {

        // act
        val area = Day12().area(garden1, Point2D(0, 0))

        // assert
        assertThat(area).containsOnly(
            Point2D(0, 0),
            Point2D(1, 0),
            Point2D(2, 0),
            Point2D(3, 0),
        )
    }

    @Test
    fun should_find_all_areas_of_garden1() {

        // act
        val areas = Day12().areas(garden1)

        // assert
        assertThat(areas).hasSize(5)
        // plant A
        assertThat(areas[0]).containsOnly(
            Point2D(0, 0),
            Point2D(1, 0),
            Point2D(2, 0),
            Point2D(3, 0),
        )
        // plant B
        assertThat(areas[1]).containsOnly(
            Point2D(0, 1),
            Point2D(1, 1),
            Point2D(0, 2),
            Point2D(1, 2),
        )
        // plant C
        assertThat(areas[2]).containsOnly(
            Point2D(2, 1),
            Point2D(3, 3),
            Point2D(2, 2),
            Point2D(3, 2),
        )
        // plant D
        assertThat(areas[3]).containsOnly(
            Point2D(3, 1),
        )
        // plant E
        assertThat(areas[4]).containsOnly(
            Point2D(0, 3),
            Point2D(1, 3),
            Point2D(2, 3),
        )
    }

    @Test
    fun should_find_all_areas_of_garden2() {

        // act
        val areas = Day12().areas(garden2)

        // assert
        assertThat(areas).hasSize(5)
        println(areas)
    }

    @Test
    fun should_find_all_fences_of_area_A_of_garden1() {
        // arrange
        val area = listOf(
            Point2D(0, 0),
            Point2D(1, 0),
            Point2D(2, 0),
            Point2D(3, 0),
        )

        // act
        val fences = Day12().fences(area)

        // assert
        assertThat(fences).hasSize(10)
    }

    @Test
    fun should_find_all_fences_of_area_B_of_garden1() {
        // arrange
        val area = listOf(
            Point2D(0, 1),
            Point2D(1, 1),
            Point2D(0, 2),
            Point2D(1, 2),
        )

        // act
        val fences = Day12().fences(area)

        // assert
        assertThat(fences).hasSize(8)
    }

    @Test
    fun should_find_all_fences_of_area_C_of_garden1() {
        // arrange
        val area = listOf(
            Point2D(2, 1),
            Point2D(3, 3),
            Point2D(2, 2),
            Point2D(3, 2),
        )

        // act
        val fences = Day12().fences(area)

        // assert
        assertThat(fences).hasSize(10)
    }

    @Test
    fun should_find_all_fences_of_area_D_of_garden1() {
        // arrange
        val area = listOf(
            Point2D(3, 1),
        )

        // act
        val fences = Day12().fences(area)

        // assert
        assertThat(fences).hasSize(4)
    }

    @Test
    fun should_find_all_fences_of_area_E_of_garden1() {
        // arrange
        val area = listOf(
            Point2D(0, 3),
            Point2D(1, 3),
            Point2D(2, 3),
        )

        // act
        val fences = Day12().fences(area)

        // assert
        assertThat(fences).hasSize(8)
    }

    @Test
    fun should_find_all_fences_of_area_O_of_garden2() {
        // arrange
        val area = listOf(
            Point2D(0, 0),
            Point2D(0, 1),
            Point2D(1, 0),
            Point2D(0, 2),
            Point2D(2, 0),
            Point2D(0, 3),
            Point2D(1, 2),
            Point2D(2, 1),
            Point2D(3, 0),
            Point2D(0, 4),
            Point2D(2, 2),
            Point2D(4, 0),
            Point2D(1, 4),
            Point2D(2, 3),
            Point2D(3, 2),
            Point2D(4, 1),
            Point2D(2, 4),
            Point2D(4, 2),
            Point2D(3, 4),
            Point2D(4, 3),
            Point2D(4, 4),
        )

        // act
        val fences = Day12().fences(area)

        // assert
        assertThat(fences).hasSize(36)
    }

    @Test
    fun should_solve_part1_with_garden1() {

        // act
        val price = Day12().solvePart1(garden1)

        // assert
        assertThat(price).isEqualTo(140)
    }

    @Test
    fun should_solve_part1_with_garden2() {

        // act
        val price = Day12().solvePart1(garden2)

        // assert
        assertThat(price).isEqualTo(772)
    }

    @Test
    fun should_solve_part1_with_example_garden() {
        // arrange
        val garden = Day12().loadData(Path.of("src", "test", "resources", "Day12_TestData.txt"))

        // act
        val price = Day12().solvePart1(garden)

        // assert
        assertThat(price).isEqualTo(1930)
    }

    @Test
    fun should_find_horizontal_sides_of_area_A() {
        // arrange
        val fences = Day12().fences(areaA)

        // act
        val sidesHorizontal = Day12().sidesHorizontal(fences)

        // assert
        assertThat(sidesHorizontal).hasSize(2)
    }

    @Test
    fun should_find_horizontal_side_in_areaA() {
        // arrange
        val fences = Day12().fences(areaA)

        // act
        val sideHorizontal = Day12().sideHorizontal(Point2D(0, -1), fences)

        // assert
        assertThat(sideHorizontal).containsOnly(
            Point2D(0, -1),
            Point2D(1, -1),
            Point2D(2, -1),
            Point2D(3, -1),
        )
    }

    @Test
    fun should_find_vertical_side_in_areaA() {
        // arrange
        val fences = Day12().fences(areaA)

        // act
        val sideVertical = Day12().sideVertical(Point2D(-1, 0), fences)

        // assert
        assertThat(sideVertical).containsOnly(
            Point2D(-1, 0),
        )
    }


    @Test
    fun should_find_vertical_sides_of_area_A() {
        // arrange
        val day12 = Day12()
        val fences = day12.fences(areaA).toMutableList()
        val sidesHorizontal = day12.sidesHorizontal(fences)
        fences.removeAll(sidesHorizontal.flatten())

        // act
        val sidesVertical = day12.sidesVertical(fences)

        // assert
        assertThat(sidesVertical).hasSize(2)
    }

    @Test
    fun should_find_all_sides_of_AreaA() {
        // arrange
        val day12 = Day12()
        val fences = day12.fences(areaA)

        // act
        val sides = day12.sides(fences)

        // assert
        assertThat(sides).isEqualTo(4)

    }
}