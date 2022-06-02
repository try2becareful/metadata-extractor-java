#!/bin/bash
docker build -t metadata-extractor .
docker run --mount type=bind,source=/home/rustam/metadata-extractor-java/pdftest/Files,target=/app/pdftest/Files metadata-extractor