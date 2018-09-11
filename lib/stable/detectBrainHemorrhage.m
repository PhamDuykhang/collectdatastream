function  [info,vector] = detectBrainHemorrhage(dicompath)
    info = dicominfo(dicompath); % ??i s? là ???ng dãn file t?o thành hình ?nh nh? phân c?a vùng xu?t huy?t
    RescaleSlope = info.RescaleSlope;
    RescaleIntercept = info.RescaleIntercept; % tính toán RescaleSlope và RescaleIntercept
    I = dicomread(info);
    [r , c] = size(I);
    hematoma = zeros(r,c);
    for i = 1:r
        for j = 1:c
            hu= (I(i,j)*RescaleSlope + RescaleIntercept);
            if hu>40 && hu<90
                hematoma(i,j)=1;
            else
                hematoma(i,j)=0;
            end
        end
    end
  im2= bwmorph(hematoma,'open');
  CC = bwconncomp(im2);
  S = regionprops(CC, 'Area');
  thresholdpixel = max([S.Area]);
  im2 = bwareaopen(im2,thresholdpixel);
  %imshow(im2)
  s = regionprops('table',im2,'Area','centroid','EquivDiameter','Solidity','Extent','Eccentricity','MajorAxisLength','MinorAxisLength','Orientation');
  %_--------------------------------------
  skull = zeros(r,c);
  for i= 1:r
    for j = 1:c
        HU = (I(i,j) * RescaleSlope + RescaleSlope);
        if HU >200
            skull(i,j) = 1; %img(i,j): binary img (1:white, 0:black)
        else 
            skull(i,j) = 0;
        end
    end
  end
  CC = bwconncomp(skull);
  sthe = regionprops(CC, 'Area');
  thresholdpixel = max([sthe.Area]);
  skull = bwareaopen(skull,thresholdpixel);
  propertiesSkull = regionprops(skull,'centroid');
  centroidSkull = cat(1, propertiesSkull.Centroid);
  X1=centroidSkull(:,1);
  Y1=centroidSkull(:,2);
  %_-------=------------------------------------------
  Centroid0fhematoma= s.Centroid;
  X2=Centroid0fhematoma(:,1);
  Y2=Centroid0fhematoma(:,2);
  %-----------------
  %Tính kho?n cách.
  distance= sqrt((X1-X2)^2+(Y1-Y2)^2);
  %---------------
  sBoudinbox =regionprops(im2,'Image');
  sss=regionprops(sBoudinbox.Image,'Area');
  AreaBoudingbox=sss.Area;
  %--------------
  name=char(info.PatientName.FamilyName);
  patientID=char(info.PatientID);
  patientAge=char(info.PatientAge);
  patientSex=char(info.PatientSex);
  accessionNumber=char(info.AccessionNumber);
  modality=char(info.Modality);
  manufacturer=char(info.Manufacturer);
  institutionName=char(info.InstitutionName);
  institutionAddress=char(info.InstitutionAddress);
  spacechar=char(':');
  info = [patientID,spacechar,name,spacechar,patientAge,spacechar,patientSex,spacechar,institutionName,spacechar,institutionAddress,spacechar,accessionNumber,spacechar,manufacturer,spacechar,modality];
  vector = [s.Area,X2,Y2,s.EquivDiameter/2 *3.14,distance,s.EquivDiameter,AreaBoudingbox,s.Solidity,s.Extent,s.Eccentricity,s.MajorAxisLength,s.MinorAxisLength,s.Orientation];
 end
    