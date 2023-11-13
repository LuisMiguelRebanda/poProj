#!/bin/bash

javac -cp po-uilib.jar:. `find xxl -name "*.java"`

echo -e "EI Submissao:"
bash run_tests-EI-Submissao.sh
echo -e
echo -e "Both EI Submissao:"
bash run_testsBoth-EI-Submissao.sh
echo -e
echo -e "All EI:"
bash run_testsAllEI.sh
echo -e
echo -e "Both All EI:"
bash run_testsBothAllEI.sh
echo -e
echo -e "EF Submissao:"
bash run_tests-EF-Submissao.sh
echo -e
echo -e "Both EF Submissao:"
bash run_testsBoth-EF-Submissao.sh
echo -e
echo -e "All EF:"
bash run_testsAllEF.sh
echo -e