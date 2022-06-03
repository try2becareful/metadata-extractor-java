#!/bin/bash
sudo docker build -t metadata-extractor .
sudo docker run --mount type=bind,source=$PWD/pdftest/Files,target=/app/pdftest/Files metadata-extractor