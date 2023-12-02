import * as fs from "fs";
import * as readline from "readline";

class DayOne {
  part_one(): number {
    const lineReader = readline.createInterface({
      input: fs.createReadStream("../inputs/day_one.txt"),
      terminal: false,
    });

    lineReader.on("line", (line) => {
      console.log(line);
    });
    return -1;
  }
}

let xdo = new DayOne();
xdo.part_one();
