package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 面试题 17.18 - shortest-supersequence-lcci
 * 最短超串
 *
 * @author lixin
 * @date 2022-02-02 09:31:58
 */
public class ShortestSupersequenceLcci {
    public static void main(String[] args) {
        Solution solution = new ShortestSupersequenceLcci().new Solution();
//        int[] big = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
//        int[] small = {1, 5, 9};
//        int[] big = {1, 2, 3};
//        int[] small = {1, 2, 3};
        int[] big = {499, 867, 454, 392, 282, 345, 257, 99, 395, 452, 91, 465, 907, 214, 370, 502, 627, 372, 810, 923, 390, 401, 873, 884, 742, 62, 676, 602, 933, 43, 952, 85, 806, 90, 729, 873, 618, 589, 357, 693, 896, 762, 511, 788, 807, 760, 575, 888, 128, 322, 71, 543, 343, 952, 473, 541, 701, 727, 14, 852, 922, 566, 740, 868, 197, 416, 298, 581, 605, 454, 268, 664, 885, 452, 215, 752, 23, 980, 287, 22, 726, 300, 902, 91, 92, 608, 350, 554, 451, 402, 369, 492, 956, 673, 311, 707, 345, 893, 942, 775, 704, 695, 495, 220, 900, 12, 962, 809, 282, 283, 300, 44, 37, 742, 763, 360, 166, 577, 519, 506, 624, 946, 663, 701, 317, 770, 627, 619, 812, 670, 806, 912, 242, 172, 849, 381, 159, 945, 634, 82, 244, 840, 39, 805, 114, 750, 16, 196, 421, 149, 726, 323, 835, 5, 850, 895, 40, 904, 384, 46, 831, 120, 314, 810, 661, 277, 267, 846, 829, 241, 373, 830, 497, 915, 886, 979, 774, 411, 861, 612, 147, 30, 752, 76, 844, 777, 269, 158, 539, 642, 825, 569, 137, 872, 465, 908, 879, 368, 265, 125, 805, 434, 640, 420, 493, 240, 744, 403, 527, 749, 471, 515, 183, 876, 933, 606, 478, 729, 769, 436, 707, 6, 765, 995, 913, 468, 259, 393, 561, 599, 659, 672, 870, 620, 980, 443, 742, 327, 494, 482, 167, 122, 545, 326, 362, 953, 960, 83, 773, 995, 190, 317, 381, 941, 43, 326, 645, 508, 302, 200, 167, 791, 294, 204, 836, 805, 573, 494, 732, 113, 393, 738, 138, 333, 397, 356, 308, 729, 110, 978, 361, 465, 888, 126, 50, 303, 271, 10, 111, 956, 831, 20, 126, 413, 194, 538, 996, 282, 800, 887, 718, 92, 128, 137, 864, 428, 484, 608, 528, 927, 801, 935, 646, 896, 496, 983, 751, 565, 314, 962, 346, 340, 987, 942, 588, 326, 3, 584, 612, 310, 837, 449, 183, 597, 316, 953, 895, 648, 693, 484, 764, 71, 181, 719, 360, 106, 845, 635, 244, 721, 633, 200, 417, 9, 600, 41, 516, 697, 849, 414, 682, 390, 672, 413, 155, 154, 970, 176, 807, 123, 227, 936, 645, 485, 228, 259, 360, 793, 93, 124, 358, 881, 735, 832, 238, 794, 109, 589, 284, 248, 500, 910, 23, 919, 671, 990, 248, 47, 527, 139, 403, 291, 179, 886, 963, 671, 556, 463, 696, 669, 892, 912, 76, 432, 247, 880, 377, 263, 450, 351, 293, 384, 313, 524, 375, 307, 274, 128, 784, 148, 803, 663, 767, 983, 689, 667, 985, 103, 175, 778, 227, 80, 64, 280, 802, 93, 409, 887, 464, 803, 104, 632, 642, 561, 408, 965, 350, 308, 845, 56, 576, 962, 907, 231, 413, 900, 96, 108, 793, 115, 596, 976, 693, 240, 430, 538, 824, 811, 660, 126, 194, 993, 184, 545, 34, 960, 67, 943, 435, 139, 234, 444, 918, 301, 83, 847, 592, 648, 200, 614, 43, 702, 927, 232, 150, 755, 490, 46, 326, 842, 163, 22, 195, 949, 968, 802, 68, 198, 815, 741, 28, 30, 701, 840, 487, 126, 307, 826, 520, 270, 864, 984, 898, 490, 964, 1, 265, 991, 925, 506, 709, 293, 528, 176, 464, 676, 788, 430, 804, 637, 813, 838, 747, 857, 509, 560, 569, 629, 697, 613, 534, 912, 311, 428, 705, 132, 77, 893, 445, 216, 598, 903, 176, 358, 554, 499, 461, 197, 42, 298, 620, 682, 816, 755, 465, 363, 345, 256, 426, 195, 264, 219, 336, 625, 443, 533, 213, 446, 18, 264, 262, 214, 792, 959, 132, 998, 341, 373, 2, 945, 447, 29, 557, 818, 892, 311, 491, 883, 275, 936, 653, 20, 955, 349, 784, 49, 145, 387, 560, 720, 613, 637, 539, 483, 702, 66, 483, 909, 455, 732, 734, 383, 748, 453, 76, 488, 189, 917, 828, 270, 335, 820, 64, 176, 204, 554, 559, 551, 850, 297, 294, 619, 889, 912, 873, 406, 480, 825, 792, 194, 107, 278, 340, 680, 233, 654, 732, 356, 644, 577, 227, 483, 549, 484, 55, 377, 958, 453, 649, 826, 96, 692, 360, 639, 889, 693, 5, 733, 767, 538, 63, 611, 394, 829, 618, 4, 269, 331, 695, 636, 26, 625, 878, 799, 375, 295, 693, 676, 357, 446, 542, 753, 935, 75, 544, 783, 15, 5, 387, 400, 4, 770, 974, 735, 90, 562, 348, 248, 992, 985, 503, 985, 601, 291, 625, 402, 601, 685, 743, 796, 346, 89, 90, 73, 296, 766, 348, 328, 184, 533, 299, 194, 778, 463, 406, 820, 494, 623, 475, 472, 340, 411, 294, 649, 108, 727, 202, 411, 40, 557, 880, 769, 574, 937, 934, 259, 7, 681, 61, 831, 894, 818, 791, 435, 279, 784, 794, 318, 917, 559, 776, 524, 265, 878, 832, 788, 850, 251, 852, 693, 322, 214, 6, 758, 39, 921, 391, 89, 256, 436, 272, 182, 321, 373, 562, 804, 73, 818, 773, 168, 172, 340, 665, 487, 898, 110, 175, 120, 595, 581, 707, 399, 978, 920, 305, 734, 629, 13, 364, 391, 771, 610, 877, 242, 284, 484, 254, 112, 599, 355, 637, 143, 298, 618, 111, 148, 111, 283, 783, 32, 191, 985, 64, 534, 45, 103, 423, 668, 192, 268, 896, 775, 277, 861, 686, 291, 918, 282, 283, 901, 496, 764, 246, 686, 64, 37, 656, 770, 616, 404, 213, 779, 42, 235, 512, 70, 508, 934, 572, 137, 969, 41, 770, 943, 835, 209, 657, 154, 531, 746, 521, 206, 950, 618, 583, 202, 286, 788, 288, 184, 222, 781, 856, 530, 341, 844, 896, 22, 337, 142, 137, 789, 941, 981, 190, 159, 907, 431, 578, 310, 827, 875, 591, 46, 322, 772, 677, 345, 989, 51, 581, 979, 464, 909, 213, 987, 946, 268, 668, 649, 92, 949, 839, 315, 987, 471, 239, 785, 103, 17, 584, 384, 382, 250, 63, 665, 799, 683, 799, 595, 211, 621, 575, 142, 242, 930, 488, 454, 166, 162};
        int[] small = {375, 451, 491, 114, 383, 766, 898, 46, 277, 362, 288, 493, 310, 390, 569, 856, 244, 200, 921, 327, 576, 215, 148, 740, 519, 826, 528, 599, 811, 806, 213, 987, 900, 279, 506, 311, 611, 363, 420, 727, 776, 544, 296, 76, 49, 799, 337, 984, 472, 815, 877, 976, 184, 106, 361, 373, 963, 307, 649, 108, 577, 612, 301, 158, 2, 109, 85, 845, 411, 145, 887, 271, 895, 113, 272, 231, 351, 784, 495, 962, 400, 461, 903, 896, 829, 783, 885, 990, 623, 264, 75, 886, 918, 832, 251, 20, 889, 645, 556, 436, 452, 646, 471, 636, 831, 463, 196, 735, 508, 465, 807, 480, 89, 149, 549, 936, 360, 345, 43, 358, 80, 63, 753, 538, 268, 96, 482, 778, 943, 729, 198, 247, 17, 779, 873, 629, 278, 66, 483, 613, 742, 162, 813, 693, 323, 222, 601, 318, 369, 554, 308, 194, 137, 434, 77, 637, 758, 909, 176, 181, 56, 341, 499, 598, 384, 770, 949, 659, 328, 189, 875, 447, 364, 377, 541, 748, 454, 115, 667, 298, 107, 907, 408, 190, 809, 302, 227, 991, 294, 801, 126, 175, 656, 934, 214, 771, 357, 315, 435, 605, 996, 591, 773, 534, 283, 51, 733, 40, 64, 792, 671, 232, 520, 62, 747, 828, 406, 449, 416, 682, 803, 111, 732, 665, 91, 293, 71, 490, 543, 533, 718, 800, 755, 313, 42, 331, 166, 985, 197, 573, 888, 606, 316, 142, 810, 250, 915, 6, 767, 5, 99, 73, 37, 93, 428, 502, 835, 209, 216, 497, 417, 509, 92, 952, 257, 818, 265, 709, 965, 524, 23, 155, 220, 852, 90, 13, 764, 414, 775, 246, 9, 677, 796, 695, 850, 734, 864, 485, 154, 788, 291, 791, 132, 627, 270, 769, 124, 562, 861, 937, 494, 892, 446, 701, 34, 182, 426, 295, 14, 488, 849, 211, 263, 421, 837, 123, 572, 726, 893, 697, 720, 473, 1, 640, 128, 397, 608, 235, 511, 884, 284, 827, 762, 741, 394, 686, 993, 705, 242, 527, 602, 619, 846, 902, 744, 487, 910, 634, 297, 592, 254, 282, 581, 980, 409, 794, 805, 183, 566, 204, 802, 760, 355, 432, 103, 789, 333, 82, 648, 793, 322, 676, 625, 672, 654, 67, 503, 844, 912, 642, 816, 692, 18, 512, 492, 41, 953, 765, 453, 22, 820, 774, 964, 942, 443, 904, 401, 685, 430, 878, 455, 248, 913, 530, 484, 269, 445, 620, 172, 393, 804, 147, 30, 168, 968, 946, 26, 584, 28, 179, 404, 413, 839, 356, 680, 317, 668, 110, 979, 143, 559, 670, 314, 195, 274, 159, 256, 464, 657, 867, 983, 120, 382, 368, 206, 673, 335, 387, 857, 125, 340, 496, 992, 303, 574, 326};
        System.out.println(Arrays.toString(solution.shortestSeq(big, small)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] shortestSeq(int[] big, int[] small) {
            int n = big.length;
            int[] need = new int[1000000];
            for (int j : small) {
                need[j]++;
            }
            int t = small.length;
            int left = 0, right = 0;
            int start = 0, len = Integer.MAX_VALUE;
            while (right < n) {
                int cur = big[right];
                if (need[cur] > 0) {
                    t--;
                }
                need[cur]--;
                if (t == 0) {
                    while (left < right && need[big[left]] < 0) {
                        need[big[left]]++;
                        left++;
                    }
                    if (right - left + 1 < len) {
                        len = right - left + 1;
                        start = left;
                    }
                    need[big[left]]++;
                    t++;
                    left++;
                }
                right++;
            }
            return len == Integer.MAX_VALUE ? new int[]{} : new int[]{start, start + len - 1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
