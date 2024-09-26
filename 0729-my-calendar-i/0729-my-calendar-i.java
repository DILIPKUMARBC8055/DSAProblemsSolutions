class MyCalendar {
    ArrayList<ArrayList<Integer>> data;

    public MyCalendar() {
        data = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        ArrayList<Integer> interval = new ArrayList<>();
        interval.add(start);
        interval.add(end);
        if (data.size() == 0) {
            data.add(interval);
            return true;
        } else {
            int index = findClosestIndex(data, start, 0, data.size() - 1);
            //System.out.println(index + " " + data.get(index).get(0));
            if (
                index >= 0 &&
                (
                    (start >= data.get(index).get(0) && start < data.get(index).get(1)) ||
                    (end > data.get(index).get(0) && end <= data.get(index).get(1)) ||
                    (start < data.get(index).get(0) && end > data.get(index).get(1))
                )
            ) {
                // Overlap with the interval at 'index'
                return false;
            }
            if (
                index - 1 >= 0 &&
                (
                    (start >= data.get(index - 1).get(0) && start < data.get(index - 1).get(1)) ||
                    (end > data.get(index - 1).get(0) && end <= data.get(index - 1).get(1)) ||
                    (start < data.get(index - 1).get(0) && end > data.get(index - 1).get(1))
                )
            ) {
                // Overlap with the interval at 'index + 1'
                return false;
            }
            if (
                index + 1 < data.size() &&
                (
                    (start >= data.get(index + 1).get(0) && start < data.get(index + 1).get(1)) ||
                    (end > data.get(index + 1).get(0) && end <= data.get(index + 1).get(1)) ||
                    (start < data.get(index + 1).get(0) && end > data.get(index + 1).get(1))
                )
            ) {
                // Overlap with the interval at 'index + 1'
                return false;
            }

            if (start < data.get(index).get(0)) {
                data.add(index, interval);
            } else {
                data.add(index + 1, interval);
            }
            //printAll(data);

            return true;
        }
    }

    public void printAll(ArrayList<ArrayList<Integer>> data) {
        for (ArrayList<Integer> arr : data) {
            System.out.println(arr.get(0) + "  " + arr.get(1));
        }
        System.out.println("___________________________");
    }

    public int findClosestIndex(ArrayList<ArrayList<Integer>> data, int target, int start, int end) {
        if (start >= end) {
            return start;
        }
        int mid = (start + end) / 2;
        if (data.get(mid).get(0) == target) {
            return mid;
        } else if (data.get(mid).get(0) > target) {
            return findClosestIndex(data, target, start, mid - 1);
        } else {
            return findClosestIndex(data, target, mid + 1, end);
        }
    }
}
/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
