(def a (dge 2 2 [-4 -6
                 3 5]
            {:layout :row}))

(def eigenvalues (ev a))

(def lambda1 (entry eigenvalues 0 0))

(def lambda2 (entry eigenvalues 1 0))

(def eigenvals (dge 2 2))

(def eigenvect (raw a))

(ev! (copy a) eigenvals nil eigenvect)

(def x1 (col eigenvect 0))

(def x2 (col eigenvect 1))

(mv a x1)

(scal lambda1 x1)

(axpy -1 (mv a x1) (scal lambda1 x1))

(seq x1)

(nrm2 x1)

(let [a (dge 3 3 [5 4 2 4 5 2 2 2 2])
      evec (dge 3 3)
      eval (dge 3 2)]
  (ev! a eval nil evec)
  [(col eval 0) evec])

(let [a (dge 2 2 [7 3 -10 -4])
      c (dge 2 2 [2 1 5 3])
      inv-c (tri! (trf c))];; we can not afford to destroy c!
  (mm inv-c (mm a c)))

(let [a (dge 2 2 [-4 3 -6 5])]
  (col (ev a) 0))

(let [a (dge 2 2 [-4 3 -6 5])
      evec (dge 2 2)
      eval (ev! (copy a) (raw a) nil evec)
      inv-evec (tri! (trf evec))]
  (def d (mm inv-evec (mm a evec))))

(fmap! (pow 9) (dia d))

