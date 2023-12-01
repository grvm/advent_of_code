class DayOne
  STR_MAP = {
    "one"   => "one1one",
    "two"   => "t2o",
    "three" => "t3e",
    "four"  => "f4r",
    "five"  => "f5e",
    "six"   => "s6x",
    "seven" => "s7n",
    "eight" => "e8t",
    "nine"  => "n9e",
  }

  LINES = File.read_lines("../inputs/day_one.txt")

  def self.part_one
    LINES.map do |line|
      calibration_value(line: line)
    end.sum
  end

  def self.part_two
    LINES.map do |line|
      STR_MAP.each do |reg|
        line = line.gsub(*reg)
      end
      calibration_value(line: line)
    end.sum
  end

  private def self.calibration_value(line : String) : Int32
    digits = line.scan(/\d/).map(&.to_a).flatten
    if digits.size == 0
      puts "GOT A SINGLE"
      calibration_value = 0
    else
      calibration_value = "#{digits.first}#{digits.last}".to_i
    end
  end
end

puts DayOne.part_one
puts DayOne.part_two
