use regex::Regex;
use std::fs::read_to_string;

const NUM_MAP: &'static [&'static str] = &[
    r"zero", r"one", r"two", r"three", r"four", r"five", r"six", r"seven", r"eight", r"nine",
];
fn main() {
    let file = read_to_string("../inputs/day_one.txt").unwrap();
    println!("{}", part_one(&file));
    println!("{}", part_two(&file));
}

fn part_one(file: &str) -> i32 {
    let mut sum = 0;
    for line in file.lines() {
        sum += summate(line);
    }
    sum
}

fn part_two(file: &str) -> i32 {
    let mut sum = 0;
    for line in file.lines() {
        let mut new_line = line.to_string();
        let _x = NUM_MAP.iter().enumerate().for_each(|(pos, pattern)| {
            let replacement = &format!("{}{}{}", pattern, pos, pattern).to_owned();
            new_line = new_line.replace(pattern, replacement);
        });

        sum += summate(Box::leak(new_line.into_boxed_str()));
    }
    sum
}

fn summate(line: &str) -> i32 {
    let re = Regex::new(r"\d").unwrap();
    let digits: Vec<_> = re.find_iter(line).map(|m| m.as_str()).collect();

    let calibration_value: i32 = format!("{}{}", digits.first().unwrap(), digits.last().unwrap())
        .parse()
        .unwrap();
    calibration_value
}
