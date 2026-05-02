package entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Score {
    private int runs=0;
    private int wickets=0;
}
