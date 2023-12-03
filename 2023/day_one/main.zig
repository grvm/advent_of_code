const std = @import("std");

pub fn main() !void {
    // var pappu = "Pappu";
    var file = try std.fs.cwd().openFile("day_one.txt", .{});
    defer file.close();

    var stream = std.io.bufferedReader(file.reader());
    var lines = stream.reader();

    var buf: [1024]u8 = undefined;

    var fbs = std.io.fixedBufferStream(&buf);

    while (try lines.streamUntilDelimiter(fbs.writer(), '\n', fbs.buffer.len)) |line| {
        std.debug.print("{s}\n", .{line});
    }
}
