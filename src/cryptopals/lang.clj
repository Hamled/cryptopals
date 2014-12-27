(ns cryptopals.lang)

(def char-freq-table-english
  { \a  8.12
    \b  1.49
    \c  2.78
    \d  4.25
    \e 12.70
    \f  2.28
    \g  2.02
    \h  6.09
    \i  6.97
    \j  0.15
    \k  0.77
    \l  4.03
    \m  2.41
    \n  6.75
    \o  7.51
    \p  1.93
    \q  0.10
    \r  5.99
    \s  6.33
    \t  9.06
    \u  2.76
    \v  0.98
    \w  2.36
    \x  0.15
    \y  1.97
    \z  0.07
    \A  8.12
    \B  1.49
    \C  2.78
    \D  4.25
    \E 12.70
    \F  2.28
    \G  2.02
    \H  6.09
    \I  6.97
    \J  0.15
    \K  0.77
    \L  4.03
    \M  2.41
    \N  6.75
    \O  7.51
    \P  1.93
    \Q  0.10
    \R  5.99
    \S  6.33
    \T  9.06
    \U  2.76
    \V  0.98
    \W  2.36
    \X  0.15
    \Y  1.97
    \Z  0.07
    \space 0.00})

(defn char-freq-english
  "Frequency score of a given character in English."
  [c]
  (get char-freq-table-english c -10.00))

(defn score-text-english-simple
  "Score a given text for its likelihood of being English.
  Because this score is not length-dependent it should only be used
  for comparing between strings of similar length."
  [text]
  (reduce + (map char-freq-english text)))
