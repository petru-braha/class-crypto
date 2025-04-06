## c2 - perfect security

- security model = security goal(properties) + attack model(adversary type, attack type)

- random variable = function
  - domain == set of random events
  - co-domain == set of measurable events
  
  - it is the domain of a probability distribution

  - kinda a set of values
  - kinda a probability distribution
  
- perfect secure chiper: P_M(m|c) = P_M(m)
- perfect indistinguishability P_C(c|m_0) == P_C(c|m_1), any m_i

- one time pad
  - perfect secure
  - keys are randomly generated
  - |k| == |m| == |c|
  - e_k(m) == d_k(m) == concat(xor(m_i, k_i))

- algorithms:
  - deterministic y = A(x)
  - probabilistic y <- A(x)
    - adversaries

- see c2 theorem 5
- perfect security => |K| >= |M| && |K| >= |C|

## c4 - indistinguishability

- negligible function
  - smaller than the inverse of any poly (asta e asa ca sa faci o idee)
  - `|f(n)| < 1/n^c`, any c > 0, any n >= n_min, exists n_min, n belongs to N*
    - there exists a minimum such that
    - iteratively find a solution and then try to find a smaller one
  - numitorul functiei este exponential

- family = a collection of probability density functions that differ only with respect to one or more parameters
  - normal
  - binomial
  - bernoulli

- indistinguishability
  - statistical: △(X_n, Y_n) is negligible
  - computational: △(A(X_n), A(Y_n)) is negligible
