# class Solution:
#     def merge(self, intervals: List[List[int]]) -> List[List[int]]:
class Solution:
    def merge(self, intervals):
        intervals.sort()
        v = []
        start = intervals[0][0]
        end = intervals[0][1]
        for i in range(len(intervals)):
            if intervals[i][0] > end and intervals[i][1] > end:
                a = [start, end]
                v.append(a)
                start = intervals[i][0]
                end = intervals[i][1]
            elif intervals[i][1] > end:
                end = intervals[i][1]
        last = [start, end]
        v.append(last)
        return v