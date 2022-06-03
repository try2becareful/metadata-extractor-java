#!/bin/bash
docker build -t metadata-extractor .
docker run --mount type=bind,source=$PWD/pdftest/Files,target=/app/pdftest/Files metadata-extractor
docker push metadata-extractor