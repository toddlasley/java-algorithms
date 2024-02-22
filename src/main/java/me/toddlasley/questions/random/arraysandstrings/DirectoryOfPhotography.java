package me.toddlasley.questions.random.arraysandstrings;

// A photography set consists of NN cells in a row, numbered from 1 to N in order, and can be represented by a
// string C of length N.
// - indices with P can contain a photographer
// - indices with A can contain an actor
// - indices with B can contain a backdrop
// - indices with . must be empty
// A photograph is considered "artistic" if an actor is between and within X
// and Y spaces of a photographer and backdrop. Given the string C, how many artistic photographs can be taken?


public class DirectoryOfPhotography {
    public static int getArtisticPhotographCount(final int N, final String C, final int X, final int Y) {
        final int[] photographers = new int[N + 1];
        final int[] backdrops = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            final char c = C.charAt(i - 1);

            photographers[i] = photographers[i - 1] + (c == 'P' ? 1 : 0);
            backdrops[i] = backdrops[i - 1] + (c == 'B' ? 1 : 0);
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            if (C.charAt(i) == 'A') {
                final int leftStart = Math.max(i - Y, 0);
                final int leftEnd = Math.max(i - X + 1, 0);
                final int rightStart = Math.min(i + X, N);
                final int rightEnd = Math.min(i + Y + 1, N);
                count += (photographers[leftEnd] - photographers[leftStart]) * (backdrops[rightEnd] - backdrops[rightStart]);
                count += (photographers[rightEnd] - photographers[rightStart]) * (backdrops[leftEnd] - backdrops[leftStart]);
            }
        }


        return count;
    }

    public static void main(final String[] args) {
        getArtisticPhotographCount(8, ".PBAAP.B", 1, 3);
    }
}
