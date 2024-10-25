This code sample - implementation of part Game Life realization.
Game field - grid NxM with 0 or 1 values in each.
Every generation grid change values into cells by several rules.

Rules for value of each cell:
    1. 2 neighbors are alive - this cell keep her state;
    2. 0, 1 or more than 3 neighbors are alive - this cell was died;
    3. correctly 3 neighbors are alive - this cell became alive.

This sample - method for calculate next generation.

For example let's check this grid - 3x3
As input data send string - "000_111_000"
For this sample answer is - "010_010_010"