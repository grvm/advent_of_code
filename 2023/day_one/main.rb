class DayOne
  NUM_MAP = {
    'one' => 'one1one',
    'two' => 'two2two',
    'three' => 'three3three',
    'four' => 'four4four',
    'five' => 'five5five',
    'six' => 'six6six',
    'seven' => 'seven7seven',
    'eight' => 'eight8eight',
    'nine' => 'nine9nine'
  }

  LINES = File.readlines('../inputs/day_one.txt')

  class << self
    def part_one
      LINES.collect do |line|
        digits = line.scan(/\d/)

        "#{digits.first}#{digits.last}".to_i
      end.sum
    end

    def part_two
      LINES.collect do |line|
        NUM_MAP.each do |reg, val|
          line.gsub!(reg, val)
        end

        digits = line.scan(/\d/)
        "#{digits.first}#{digits.last}".to_i
      end.sum
    end
  end
end

puts DayOne.part_one
puts DayOne.part_two
